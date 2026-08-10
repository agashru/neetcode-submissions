class Solution {
    public class Car{
        public int position;
        public double time;

        public Car(int position, double time){
            this.position = position;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] c = new Car[n];

        for(int i = 0; i < n ; i++){
            c[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }

        Arrays.sort(c, (a,b) -> a.position -  b.position);

        int fleet = 1;
        double tt = c[n-1].time;
        for(int i = n -2 ; i >= 0; i--){
            if(c[i].time > tt){
                tt = c[i].time;
                fleet++;
            }
        }
        return fleet;

    }
}
