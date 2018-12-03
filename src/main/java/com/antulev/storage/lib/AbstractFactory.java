package com.antulev.storage.lib;

public interface AbstractFactory<M extends Model<ID>, ID> {
	M initBluePrint();
	M buildElements(M newModel);
	M deleteElements(M newModel);
}
