class Solution {
    public boolean isValid(String s) {
        boolean curl=false, square=false, paran=false;
        String current = "", cu = "",sq = "",pa = "";
        for (int i=0; i<s.length(); i++){
            System.out.println("Start");
            System.out.println("current: " + current);
            System.out.println("curl: " + curl);
            System.out.println("square: " + square);
            System.out.println("paran: " + paran);
            System.out.println("cu: " + cu + "  sq: " + sq + "  pa: " + pa);
            
            if (s.charAt(i) == '('){
                curl = true;
                if (current == "square"){
                    cu = "square";
                }
                if (current =="paran"){
                    cu = "paran";
                }
                current = "curl";
            }
            if (s.charAt(i) == '['){
                square = true;
                if (current == "curl"){
                    sq = "curl";
                }
                if (current =="paran"){
                    sq = "paran";
                }
                current = "square";
            }
            if (s.charAt(i) == '{'){
                paran = true;
                if (current == "square"){
                    pa = "square";
                }
                if (current =="curl"){
                    pa = "curl";
                }
                current = "paran";
            }
            if (s.charAt(i) == ')'){
                //System.out.println("2");
                if (curl != true){
                    return false;
                }
                //System.out.println("error1");
                if (current != "curl"){
                    return false;
                }
                //System.out.println("error2");
                curl = false;
                if (current != ""){
                    if (cu == "square"){
                        current = "square";
                    }
                    if (cu == "paran"){
                        current = "paran";
                    }
                    if (cu ==""){
                        current = "";
                    }
                }
            }
            if (s.charAt(i) == ']'){
                //System.out.println("1");
                if (square != true){
                    return false;
                }
                if (current != "square"){
                    return false;
                }
                square = false;
                if (current != ""){
                    if (sq == "curl"){
                        current = "curl";
                    }
                    if (sq == "paran"){
                        current = "paran";
                    }
                    if (sq ==""){
                        current = "";
                    }
                }
            }
            if (s.charAt(i) == '}'){
                if (paran != true){
                    return false;
                }
                if (current != "paran"){
                    return false;
                }
                paran = false;
                if (current != ""){
                    if (pa == "square"){
                        current = "square";
                    }
                    if (pa == "curl"){
                        current = "curl";
                    }
                    if (pa ==""){
                        current = "";
                    }
                }
            }
            System.out.println("End");
            System.out.println("current: " + current);
            System.out.println("curl: " + curl);
            System.out.println("square: " + square);
            System.out.println("paran: " + paran);
            System.out.println("cu: " + cu + "  sq: " + sq + "  pa: " + pa);
            System.out.println("\n");
        }
        if (curl || square || paran){
            return false;
        }
        return true;
    }
}
