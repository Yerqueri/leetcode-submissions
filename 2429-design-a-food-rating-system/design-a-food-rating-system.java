class FoodRatings {
    class Rating{
        String foodItem;
        int rating;

        Rating(String foodItem, int rating){
            this.foodItem = foodItem;
            this.rating = rating;
        }

        // Rating(){
        // }

        // public String toString(){
        //     return "{"+this.foodItem+" : "+this.rating+"}";
        // }
    }
    Map<String,TreeSet<Rating>> cuisineRatingMap; 

    Map<String,Rating> itemRatingMap;

    Map<String,String> foodCuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineRatingMap= new HashMap<String,TreeSet<Rating>>();
        itemRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        
        for(int i=0;i<foods.length;i++){
            Rating rating = new Rating(foods[i],ratings[i]);
            itemRatingMap.put(foods[i],rating);
            TreeSet<Rating> set = cuisineRatingMap.getOrDefault(cuisines[i], getRatingsSet());
            set.add(rating);
            cuisineRatingMap.put(cuisines[i],set);
            foodCuisineMap.put(foods[i],cuisines[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);
        Rating rating = itemRatingMap.get(food);
        TreeSet<Rating> ratingSet = cuisineRatingMap.get(cuisine);
        ratingSet.remove(rating);
        rating.rating = newRating;
        itemRatingMap.put(food,rating);
        ratingSet.add(rating);
        cuisineRatingMap.put(cuisine,ratingSet);
    }
    
    public String highestRated(String cuisine) {
        return cuisineRatingMap.get(cuisine).first().foodItem;
    }

    private TreeSet<Rating> getRatingsSet(){
        return new TreeSet<Rating>((a,b)->{
            int val = Integer.compare(b.rating,a.rating);
            if(val==0){
                return a.foodItem.compareTo(b.foodItem);
            }
            return val;
        });
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */