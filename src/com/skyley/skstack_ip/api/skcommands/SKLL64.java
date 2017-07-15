package com.skyley.skstack_ip.api.skcommands;

import com.skyley.skstack_ip.api.SKUtil;

/**
* SKLL64コマンドに対応したクラス、SKCommandを継承
*/
public class SKLL64 extends SKCommand {
	/** 接続先HEXアドレス */
	private String hexAddress;

	/**
	 * コンストラクタ
	 * @param hexAddress 接続先HEXアドレス
	 */
	public SKLL64(String hexAddress) {
		this.hexAddress = hexAddress;
	}

	/**
	 * 引数チェック
	 */
	@Override
	public boolean checkArgs() {
		// TODO 自動生成されたメソッド・スタブ
		return SKUtil.isValidHexString(hexAddress, 16);
	}

	/**
	 * コマンド文字列組み立て
	 */
	@Override
	public void buildCommand() {
		// TODO 自動生成されたメソッド・スタブ
		commandString = "SKLL64 " + hexAddress + "\r\n";
	}

}
