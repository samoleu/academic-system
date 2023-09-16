public class Date {

    int day, month, year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean posterior(Date testedDate) {
        if (testedDate.year < this.year) {
            return true;
        } else if (testedDate.year == this.year) {
            if (testedDate.month < this.month) {
                return true;
            } else if (testedDate.month == this.month && testedDate.day < this.day) {
                return true;
            }
        }

        return false;
    }
}