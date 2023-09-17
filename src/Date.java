public class Date {

    private int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public boolean posterior(Date testedDate) {
        if (testedDate.year < this.year) {
            return true;
        } else if (testedDate.year == this.year) {
            if (testedDate.month < this.month) {
                return true;
            } else return testedDate.month == this.month && testedDate.day < this.day;
        }

        return false;
    }
}