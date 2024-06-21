public class ok{
    public static void main(String[] args) {
        Voiture maClio = new Voiture(4);
        maClio.demarre();
        maClio.accelere(99.8);
        
        Voiture saBerline = new Voiture(6);
        saBerline = maClio; // Ligne de l'assignation
        
        if (maClio == saBerline) {
            System.out.println("== -> true");
        } else {
            System.out.println("== -> false");
        }
        
        System.out.println(maClio);
        System.out.println(saBerline);

        maClio.SetPuissance(20);
        System.out.print(maClio.puissance);
        System.out.print(saBerline.puissance);

       
    }
}
