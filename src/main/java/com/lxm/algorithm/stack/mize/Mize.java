package com.lxm.algorithm.stack.mize;

/**
 * �Թ�����
 * @author LXM
 *
 */
public class Mize {
	/**
	 * �Թ��Ŀ��
	 */
	private final int MIZE_SIZE_WIDTH=10;
	/**
	 * �Թ��ĸ߶�
	 */
	private final int MIZE_SIZE_HEIGHT=10;
	/**
	 * �Թ�
	 */
	private MizeElement[][] mize;
	
	/**
	 * ��ʼ���Թ�
	 * @return
	 */
	public void init(){
		mize=new MizeElement[MIZE_SIZE_WIDTH][MIZE_SIZE_HEIGHT];
		for(int i=1;i<MIZE_SIZE_WIDTH-1;i++){
			for(int j=1;j<MIZE_SIZE_HEIGHT-1;j++){
				mize[i][j]=new MizeElement(0);
			}
		}
		for(int i=0;i<MIZE_SIZE_WIDTH;i++){
			mize[i][0]=new MizeElement(1);
		}
		for(int i=0;i<MIZE_SIZE_WIDTH;i++){
			mize[i][9]=new MizeElement(1);
		}
		for(int i=0;i<MIZE_SIZE_HEIGHT;i++){
			mize[0][i]=new MizeElement(1);
		}
		for(int i=0;i<MIZE_SIZE_HEIGHT;i++){
			mize[9][i]=new MizeElement(1);
		}
		mize[3][1].setCanPass(1);
		mize[7][1].setCanPass(1);
		mize[3][2].setCanPass(1);
		mize[7][2].setCanPass(1);
		mize[5][3].setCanPass(1);
		mize[6][3].setCanPass(1);
		mize[2][4].setCanPass(1);
		mize[3][4].setCanPass(1);
		mize[4][4].setCanPass(1);
		mize[4][5].setCanPass(1);
		mize[2][6].setCanPass(1);
		mize[6][6].setCanPass(1);
		mize[2][7].setCanPass(1);
		mize[3][7].setCanPass(1);
		mize[4][7].setCanPass(1);
		mize[6][7].setCanPass(1);
		mize[7][7].setCanPass(1);
		mize[1][8].setCanPass(1);
	}
	
	public void print(){
		for(int i=0;i<MIZE_SIZE_WIDTH;i++){
			for(int j=0;j<MIZE_SIZE_HEIGHT;j++){
				System.out.print(mize[j][i].getCanPass()+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * ����ĳ���Ѿ������ʹ���
	 * @param pos
	 */
	public void setHasPass(Pos pos){
		this.getMize()[pos.getX()][pos.getY()].setHasPass(1);
	}
	
	/**
	 * �ж�ĳ���Ƿ��Ѿ������ʹ���
	 * @param pos
	 * @return
	 */
	public boolean hasPass(Pos pos){
		return this.getMize()[pos.getX()][pos.getY()].getHasPass()==1 ? true : false;
	}
	/**
	 * �ж�ĳһ�����Ƿ����ͨ��
	 * @param pos
	 * @return
	 */
	public boolean canPass(Pos pos){
		return this.getMize()[pos.getX()][pos.getY()].getCanPass() ==0 ? true : false;
	}
	
	public MizeElement[][] getMize() {
		return mize;
	}

	public void setMize(MizeElement[][] mize) {
		this.mize = mize;
	}
	
	public static void main(String[] args){
		Mize mize=new Mize();
		mize.init();
		mize.print();
	}
}
