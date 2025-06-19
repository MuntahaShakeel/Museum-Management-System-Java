package my_package;
class Guide {
    private String name;
    private int id;
    private String language;

    public Guide(String name, int id, String language) {
        this.name = name;
        this.id = id;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}