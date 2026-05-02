class MyTestingClass {
    int id;
    String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id + name.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyTestingClass)) return false;

        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id && name.equals(other.name);
    }
}