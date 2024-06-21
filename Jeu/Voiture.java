
    class Voiture {
        int puissance;
        private boolean estDemarree;
        private double vitesse;
        public Voiture (int p) {
        if (p>0)
        puissance = p;
        else
        puissance = 5;
        estDemarree = false;
        vitesse = 0;
        }
    
        public int deQuellePuissance() {
            return puissance;
            }
            public void demarre() {
            estDemarree = true;
            }
            public void accelere(double v) {
            if (estDemarree == true) {
            double avecTol;
            avecTol = v + 25;
            vitesse = vitesse + avecTol;
            }}


            public void SetPuissance(int p){
                puissance=p;
            }
        
        
        
        }