class Course extends BaseEntity {
    private String name;
    private String code;
    private int credits;
    private String level;
    private boolean isActive;
    private Institution institution;

    public Course(String name, String code, int credits, String level) {
        super();
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.level = level;
        this.isActive = true;
    }

    public String getName() { return name; }
    public String getCode() { return code; }
    public int getCredits() { return credits; }
    public String getLevel() { return level; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public Institution getInstitution() { return institution; }
    public void setInstitution(Institution institution) { this.institution = institution; }

    @Override
    public String toString() {
        String status = isActive ? "Active" : "Inactive";
        String instInfo = institution != null ? institution.getName() : "No institution";
        return String.format("Course[ID=%d, Code=%s, Name=%s, Credits=%d, Level=%s, Status=%s, Institution=%s]",
                getId(), code, name, credits, level, status, instInfo);
    }
}