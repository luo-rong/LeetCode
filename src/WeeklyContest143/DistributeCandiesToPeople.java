package WeeklyContest143;

public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] candiesForPeople = new int[num_people];
        int currCandies = 0, currPeople = 0;
        while (candies > 0) {
            if (++currCandies > candies) {
                currCandies = candies;
            }
            candiesForPeople[currPeople++] += currCandies;
            candies -= currCandies;
            if (currPeople >= num_people) {
                currPeople = 0;
            }
        }
        return candiesForPeople;
    }
}
