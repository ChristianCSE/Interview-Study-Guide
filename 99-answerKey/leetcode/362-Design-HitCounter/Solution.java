class Solution {




    public static void main(String[] args){
        HitCounter obj = new HitCounter();
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        System.out.println("=>" +obj.getHits(4));
        obj.hit(300);
        System.out.println("=>" + obj.getHits(300));
        System.out.println("=>" + obj.getHits(301));

    }
}