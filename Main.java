public class Main{
    public static void main(String[] args) {    
        try {
            TxtRead file = new TxtRead("/home/joaovictor/Quarteirao_Arvore_Binaria/casosTeste.txt");
            String resp = file.lerUmaLinha();
            int l = 0;
            String line = "";
                while((line = file.lerUmaLinha()) != null){
                    for(int c = 0; c<255; c++){ 
                       System.out.println("a");

                    }
                    l++;
                }
        }
            // System.out.println(resp);
            
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}
