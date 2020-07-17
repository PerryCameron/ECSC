package com.ecsail.enums;

public enum Officer {
	   COMMODO("CO", "Commodore"), 
	   VICECOM("VC", "Vice Commodore"),
	   PASTCOM("PC", "Past Commodore"),
	   CHAIRMA("CB", "Chairman of the Board"),
	   TREASUR("TR", "Treasurer"),
	   SECRETA("SE", "Secretary"),
	   HARBORM("HM", "Harbormaster"),
	   AHARBOR("AH", "Assistant Harbormaster"),
	   MEMBERS("MS", "Membership"),
	   AMEMBER("AM", "Assistant Membership"),
	   PUBLICI("PU", "Publicity"),
	   APUBLIC("AP", "Assistant Publicity"),
	   RACINGC("RA", "Racing"),
	   ARACING("AR", "Assistant Racing"),
	   SAFETYA("SM", "Safety and Education"),
	   ASAFETY("AS", "Assistant S and E"),
	   SOCIALC("SO", "Social"),
	   ASOCIAL("SA", "Assistant Social"),
	   SHIPSTO("SS", "Ships Store"),
	   WINTERA("WA", "Winter Activities"),
	   NEWFACI("NF", "Facilities"),
	   BDMEMBE("BM", "Board Member")
	   ;
	 
	   private String code;
	   private String text;
	 
	   private Officer(String code, String text) {
	       this.code = code;
	       this.text = text;
	   }
	 
	   public String getCode() {
	       return code;
	   }
	 
	   public String getText() {
	       return text;
	   }
	 
	   public static Officer getByCode(String officerCode) {
	       for (Officer g : Officer.values()) {
	           if (g.code.equals(officerCode)) {
	               return g;
	           }
	       }
	       return null;
	   }
	 
	   @Override
	   public String toString() {
	       return this.text;
	   }
}
