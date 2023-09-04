package com.driver;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000.0);
        validateHelper(tradeLicenseId);
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        try {
            if (this.tradeLicenseId == null) {
                throw new Exception("Valid License can not be generated");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String finalAnswer = "";

    public void validateHelper(String tradeLicenseId) {

        try {
            for (int i = 0; i < tradeLicenseId.length(); i++) {
                char ch = tradeLicenseId.charAt(i);
                if (ch >= 'A' && ch <= 'Z') continue;
                else throw new Exception("Valid License can not be generated");
            }
            for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
                char ch = tradeLicenseId.charAt(i);
                char ch2 = tradeLicenseId.charAt(i + 1);
                if (ch == ch2) {
                    rearrange(tradeLicenseId, "");
                    if(finalAnswer != null){
                        this.tradeLicenseId = finalAnswer;
                        return;
                    }
                    else throw new Exception("Valid License can not be generated");
                }
                else this.tradeLicenseId = tradeLicenseId;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void rearrange(String tradeLicenseId, String answer){
        if(tradeLicenseId.isEmpty()){
            for(int i = 0;i<answer.length();i++){
                if(answer.charAt(i) != answer.charAt(i+1)) continue;
                else return;
            }
            finalAnswer = answer;
        }

        for(int i = 0;i<tradeLicenseId.length();i++){
            if(finalAnswer != null) return;
            char ch = tradeLicenseId.charAt(0);
            String left = tradeLicenseId.substring(0,i);
            String right = tradeLicenseId.substring(i,tradeLicenseId.length());
            String rest = left + right;
            rearrange(rest, answer + ch);
        }
    }
}
