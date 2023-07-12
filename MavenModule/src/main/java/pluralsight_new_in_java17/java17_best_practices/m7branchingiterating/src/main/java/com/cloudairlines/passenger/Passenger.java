package pluralsight_new_in_java17.java17_best_practices.m7branchingiterating.src.main.java.com.cloudairlines.passenger;

public class Passenger {

    String surname;
    SeatClass seatClass;

    public Passenger(String surname, SeatClass seatClass) {
        this.surname = surname;
        this.seatClass = seatClass;
    }

    public String getSurname() {
        return surname;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "surname='" + surname + '\'' +
                ", seatClass='" + seatClass + '\'' +
                '}';
    }
}
