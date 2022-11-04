public enum Season {
    WINTER(-10.5), SPRING(15.7), SUMMER(23.4){
        @Override
        public String getTermo() {
            return "Теплое время года";
        }
    },
    AUTUMN(5.6);

    private double Temp;
    public double getTemp() {
        return Temp;
    }
    Season(double temp) {
        this.Temp = temp;
    }

    public String getTermo(){
        return "Холодное время года";
    }
}
