class Solution {
    public class Car{
        int position;
        double time;

        public Car(int position, double time){
            this.position = position;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        for(int i = 0; i < n ; i++){
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }

        Arrays.sort(cars, (a,b) -> Integer.compare(a.position, b.position) );

        double tt = cars[n-1].time;
        int count = 1;
        for(int i = n-2; i >=0; i--){
            if(cars[i].time > tt){
                count ++;
                tt = cars[i].time;
            }
        }
        return count;
    }
}
