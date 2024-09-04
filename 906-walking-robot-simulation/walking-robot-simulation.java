class Solution {
    Set<String> banned;
    public int robotSim(int[] commands, int[][] obstacles) {
        banned = new HashSet<>();
        for(int[] obstacle: obstacles){
            banned.add(obstacle[0]+"_"+obstacle[1]);
        }
        int[] curr = new int[]{0,0};
        int direction = 0;
        int max = 0;
        for(int i=0;i<commands.length;i++){
            if(commands[i]<0){
                direction = getNewDirection(direction, commands[i]);
            }else{
                curr = move(curr,direction,commands[i]);
                max = Math.max(max,curr[0]*curr[0] + curr[1]*curr[1]);
            }
        }
        return max;
    }

    private int[] move(int[] curr, int direction, int steps){
        if(direction==0){
            return moveY(curr,steps, 1);
        }else if(direction==2){
            return moveY(curr,steps, -1);
        }else if(direction==1){
            return moveX(curr,steps, 1);
        }else{
            return moveX(curr,steps, -1);
        }
    }

    private int[] moveY(int[] curr, int steps, int val){
        while(steps>0){
            String next = curr[0]+"_"+(curr[1]+val);
            if(banned.contains(next)){
                break;
            }else{
                curr[1] += val;
                steps--;
            }
        }
        return curr;
    }

    private int[] moveX(int[] curr, int steps, int val){
        while(steps>0){
            String next = (val+curr[0])+"_"+curr[1];
            if(banned.contains(next)){
                break;
            }else{
                curr[0] += val;
                steps--;
            }
        }
        return curr;
    }

    private int getNewDirection(int direction, int i){
        if(i==-1){
            return (direction+1)%4;
        }else{
            return (direction-1+4)%4;
        }
    }
}