/**
 * 
 */
package com.sportium.events.utils;

/**
 * @author Thiery
 * Enum with list of regular expressions for sports
 */
public enum SportRegex {
	
	 AMERICA_FOOTBALL(new String[]{
           "([a-zA-Z0-9\\s!@#$%^&*()_+\\-=\\[\\]{};':\"\\|,.<>\\/?]+)\\s([0-9]+)-([0-9]+)\\s(\\w+\\s\\w+)\\s(\\b(1st|2nd|3rd|4th)\\sQuarter\\b)",
     }),
	 
	 FUTBOL(new String[]{
          "([a-zA-Z0-9\\s!@#$%^&*()_+\\-=\\[\\]{};':\"\\|,.<>\\/?]+)\\s([0-9]+)-([0-9]+)\\s([a-zA-Z0-9\\s!@#$%^&*()_+\\-=\\[\\]{};':\\\"\\|,.<>\\/?]+)",
     }),
	 
	 TENIS(new String[]{
		 "([a-zA-Z0-9 ]+)\\s*\\((\\d+)\\)\\s*(\\d+)\\s*(\\d+)-([A-Za-z\\d]+)\\s*(\\d+)\\s*\\((\\d+)\\)\\s\\*(.+)",
     });
	
	 private final String[] regexList;
	 
	 SportRegex(String[] regexList) {
         this.regexList = regexList;
     }
	 
     public String[] getRegexList() {
         return regexList;
     }
	 
}
