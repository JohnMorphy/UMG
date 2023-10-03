public class Main {
    public static void main(String[] args) {
        ImplementAbstract example = new ImplementAbstract();

        Person Janek = new Person("Mickiewicz", "Janusz", "1999-01-01");
        example.add(new Person("Kowalski", "Zbigniew", "2000-05-15"));
        example.add(new Person("Kowalski", "Andrzej", "2000-05-15"));
        example.add(new Person("Januszewski", "Zbigniew", "2000-05-15"));

        example.add(Janek);
        example.add(new Person());
        System.out.println(Janek.equals(new Person("Mickiewicz", "Janusz", "1999-01-01")));

        System.out.println(example.exists(new Person("Mickiewicz", "Janusz", "1999-01-01")));

        example.letters = "this value changed";
        System.out.println(example.letters);
        System.out.println(example.thisMoment);



        Collection collection = new Collection();

        collection.add(Janek);
        example.add(new Person("Kowalski", "Andrzej", "2000-05-15"));
        example.add(new Person("Januszewski", "Zbigniew", "2000-05-15"));

        WorkOnCollections<Person> anonymous = new WorkOnCollections<Person>() {
            @Override
            public void add(Person x) {

            }

            @Override
            public boolean belongsTo(Person x) {
                return false;
            }

            @Override
            public int giveNumber() {
                return 0;
            }

            @Override
            public void print() {

            }
        }; //example of anonymous class

    }
}