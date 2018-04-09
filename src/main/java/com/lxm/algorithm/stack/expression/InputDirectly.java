package com.lxm.algorithm.stack.expression;

import java.util.ArrayList;
import java.util.List;

public class InputDirectly implements Input{
	private List<OperaterUnit> unitList;
	private int index;
	
	public InputDirectly(){
		this.unitList=new ArrayList<OperaterUnit>();
		this.index=0;
		
		this.unitList.add(OperaterUnitFactory.createOper("#"));
		this.unitList.add(OperaterUnitFactory.createOper("("));
		this.unitList.add(OperaterUnitFactory.createOpnd(1d));
		this.unitList.add(OperaterUnitFactory.createOper("+"));
		this.unitList.add(OperaterUnitFactory.createOpnd(2d));
		this.unitList.add(OperaterUnitFactory.createOper(")"));
		this.unitList.add(OperaterUnitFactory.createOper("*"));
		this.unitList.add(OperaterUnitFactory.createOper("("));
		this.unitList.add(OperaterUnitFactory.createOpnd(4d));
		this.unitList.add(OperaterUnitFactory.createOper("+"));
		this.unitList.add(OperaterUnitFactory.createOpnd(3d));
		this.unitList.add(OperaterUnitFactory.createOper(")"));
		this.unitList.add(OperaterUnitFactory.createOper("/"));
		this.unitList.add(OperaterUnitFactory.createOpnd(5d));
		this.unitList.add(OperaterUnitFactory.createOper("#"));
	}
	
	@Override
	public OperaterUnit getNext() {
		OperaterUnit unit=null;
		if(index<unitList.size()){
			unit=unitList.get(index);
			index++;
		}
		return unit;
	}

	public List<OperaterUnit> getUnitList() {
		return unitList;
	}
	
	public void setUnitList(List<OperaterUnit> unitList) {
		this.unitList = unitList;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}

}
