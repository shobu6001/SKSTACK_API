/****
Copyright (c) 2015, Skyley Networks, Inc.
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
* Redistributions of source code must retain the above copyright notice,
  this list of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.
* Neither the name of the Skyley Networks, Inc. nor the names of its contributors
  may be used to endorse or promote products derived from this software
  without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Skyley Networks, Inc. BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
****/

package com.skyley.skstack_ip.api.skevents;


/**
* EVENTイベントに対応したクラス、SKEventを実装
* @author Skyley Networks, Inc.
* @version 0.1
*/
public class SKGeneralEvent implements SKEvent {
	/** イベント番号 */
	private byte eventNumber;
	/** 送信元IPv6アドレス */
	private String senderAddress;
	/** イベント固有パラメータ */
	private byte param;

	/**
	 * イベント番号を取得
	 * @return イベント番号
	 */
	public byte getEventNumber() {
		return eventNumber;
	}

	/**
	 * 送信元IPv6アドレスを取得
	 * @return 送信元IPv6アドレス
	 */
	public String getSenderAddress() {
		return senderAddress;
	}

	/**
	 * イベント固有パラメータを取得
	 * @return イベント固有パラメータ
	 */
	public byte getParam() {
		return param;
	}

	/**
	 * 受信文字列を解析、パラメータを格納
	 */
	@Override
	public boolean parse(String raw) {
		// TODO 自動生成されたメソッド・スタブ
		if(raw == null) {
			return false;
		}

		try {
			String[] ary = raw.trim().split(" ");
			if (ary.length == 4 || ary.length == 5) {
				eventNumber = Byte.parseByte(ary[1], 16);
				senderAddress = ary[2];

				if (ary.length == 5) {
					param = Byte.parseByte(ary[4], 16);
				}

				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

}
