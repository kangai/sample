package org.common.service;

/**
 * SRP(単一責任の原則)とする為、一責務しか持てなくする。
 * 
 * @param <InOut>
 */
public interface LogicInterface<InOut> {

	/**
	 * 実行
	 * 
	 * @param bean
	 */
	void execute(InOut bean);
}
