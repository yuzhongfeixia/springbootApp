package com.afis.util;

public interface Constants {
	/**
	 * 账号状态
	 * 
	 * @author chengen
	 *
	 */
	public enum AccountStatus implements KeyValue {
		NORMAL("1", "正常"), CANCEL("2", "注销");
		AccountStatus(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String key;
		public String value;

		public String getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}
}
