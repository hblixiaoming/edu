package com.lxm.algorithm.tree.rbtree;

public class RBTree<T extends Comparable<T>> {
    private RBNode<T> root;
    private static final char RED = 'r';
    private static final char BLACK = 'b';

    public RBNode<T> search(T key, RBNode<T> node) {
        if (node != null) {
            int com = key.compareTo(node.key);
            if (com < 0) {
                return search(key, node.leftChild);
            } else if (com > 0) {
                return search(key, node.rightChild);
            } else {
                return node;
            }
        }
        return null;
    }

    public void leftRonate(RBNode<T> x) {
        RBNode<T> y = x.rightChild;
        if (y.leftChild != null) {
            y.leftChild.parent = x;
        }
        x.rightChild = y.leftChild;
        y.leftChild = x;
        y.parent = x.parent;
        if (x.parent != null) {
            if (x.parent.leftChild == x) {
                x.parent.leftChild = y;
            } else {
                x.parent.rightChild = y;
            }
        } else {
            this.root = y;
        }
        x.parent = y;
    }

    public void rightRonate(RBNode<T> x) {
        RBNode<T> y = x.leftChild;
        if (y.rightChild != null) {
            y.rightChild.parent = x;
        }
        y.parent = x.parent;
        x.leftChild = y.rightChild;
        y.rightChild = x;
        if (x.parent != null) {
            if (x.parent.leftChild == x) {
                x.parent.leftChild = y;
            } else {
                x.parent.rightChild = y;
            }
        } else {
            this.root = y;
        }
        x.parent = y;
    }

    public void insertFixUp(RBNode<T> node) {
        RBNode<T> parent, gparent;
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);
            if (gparent.leftChild == parent) {
                RBNode<T> uncle = gparent.rightChild;
                if (isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                } else {
                    if (parent.rightChild == node) {
                        leftRonate(parent);
                        RBNode<T> temp = node;
                        node = parent;
                        parent = temp;
                    }
                    setBlack(parent);
                    setRed(gparent);
                    rightRonate(gparent);
                }
            } else {
                RBNode<T> uncle = gparent.leftChild;
                if (isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                } else {
                    if (parent.leftChild == node) {
                        rightRonate(parent);
                        RBNode<T> temp = node;
                        node = parent;
                        parent = temp;
                    }
                    setBlack(parent);
                    setRed(gparent);
                    leftRonate(gparent);
                }
            }
        }
        if (root == node) {
            setBlack(node);
        }
    }


    public void deleteFixUp(RBNode<T> node, RBNode<T> parent) {
        RBNode<T> other;
        while (isBlack(node) && node != this.root) {
            if (parent.leftChild == node) {
                other = parent.rightChild;
                if (isRed(other)) {
                    setRed(parent);
                    setBlack(other);
                    leftRonate(parent);
                    continue;
                } else {
                    if (isBlack(other.leftChild) && isBlack(other.rightChild)) {
                        setRed(other);
                        node = parent;
                        parent = parentOf(node);
                    } else if (isRed(other.leftChild) && isBlack(other.rightChild)) {
                        setRed(other);
                        setBlack(other.leftChild);
                        rightRonate(other);
                    } else if (isRed(other.rightChild)) {
                        setColor(other, colorOf(parent));
                        setBlack(parent);
                        setBlack(other.rightChild);
                        leftRonate(parent);
                        break;
                    }
                }
            } else {
                other = parent.leftChild;
                if (isRed(other)) {
                    setBlack(other);
                    setRed(parent);
                    rightRonate(parent);
                    continue;
                } else {
                    if (isBlack(other.leftChild) && isBlack(other.rightChild)) {
                        setRed(other);
                        node = parent;
                        parent = parentOf(node);
                    } else if (isRed(other.rightChild) && isBlack(other.leftChild)) {
                        setRed(parent);
                        setBlack(other.rightChild);
                        leftRonate(other);
                    } else if (isRed(other.leftChild)) {
                        setColor(other, colorOf(parent));
                        setBlack(parent);
                        setBlack(other.leftChild);
                        rightRonate(parent);
                        break;
                    }
                }
            }
        }
        setBlack(node);
    }

    //红黑树添加操作
    public void insert(RBNode<T> node) {
        int com;
        RBNode<T> x = this.root;
        RBNode<T> y = null;
        while (x != null) {
            y = x;
            com = node.key.compareTo(x.key);
            if (com < 0) {
                x = x.leftChild;
            } else {
                x = x.rightChild;
            }
        }
        node.parent = y;
        if (y != null) {
            com = node.key.compareTo(y.key);
            if (com < 0) {
                y.leftChild = node;
            } else {
                y.rightChild = node;
            }
        } else {
            this.root = node;
        }
        setRed(node);
        insertFixUp(node);
    }

    public RBNode<T> parentOf(RBNode<T> node) {
        if (node != null) {
            return node.parent;
        }
        return null;
    }

    public void setParent(RBNode<T> node, RBNode<T> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    public RBNode<T> grandParentOf(RBNode<T> node) {
        return node.parent.parent;
    }

    public RBNode<T> uncleOf(RBNode<T> node) {
        if (node.parent == grandParentOf(node).leftChild) {
            return grandParentOf(node).rightChild;
        } else {
            return grandParentOf(node).leftChild;
        }
    }

    public char colorOf(RBNode<T> node) {
        if (node != null) {
            return node.color;
        }
        return BLACK;
    }

    public void setColor(RBNode<T> node, char color) {
        if (node != null) {
            node.color = color;
        }
    }

    public boolean isRed(RBNode<T> node) {
        return node != null && node.color == RED;

    }

    public void setRed(RBNode<T> node) {
        if (node != null) {
            node.color = RED;
        }
    }

    public boolean isBlack(RBNode<T> node) {
        return !isRed(node);
    }

    public void setBlack(RBNode<T> node) {
        if (node != null) {
            node.color = BLACK;
        }
    }
}
