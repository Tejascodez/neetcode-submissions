class Solution {
    public int calPoints(String[] operations) {
        List<Integer> record = new ArrayList<>();

        for(String op : operations){

            switch (op){
                case "+":
                   int n = record.size();
                   record.add(record.get(n-1)  + record.get(n-2));
                   break;

                case "D":
                record.add( 2 * record.get(record.size() - 1));
                break;

                case "C":
                record.remove(record.size() - 1);
                break;

                default:
                record.add(Integer.parseInt(op));
                break;
            }
        }

        int totalsum = 0;
        for(int score : record){
            totalsum+= score;
        }

        return totalsum;
    }
}