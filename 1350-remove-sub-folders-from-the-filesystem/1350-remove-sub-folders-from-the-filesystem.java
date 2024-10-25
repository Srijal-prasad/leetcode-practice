class Solution {
    public List<String> removeSubfolders(String[] folder) {
       PriorityQueue<String> pq=new PriorityQueue<String>((a,b)->{ return a.compareTo(b); });
       int n=folder.length;

       for(int i=0; i<n; i++){
            pq.add(folder[i]);
       }

        List<String> list=new ArrayList();
        while(!pq.isEmpty()){            
            String str=pq.poll();
            list.add(str);
            while( !pq.isEmpty() && pq.peek().indexOf(str.concat("/"),0)==0 ){
                pq.poll();
            }
        }

        return list;
    }
}