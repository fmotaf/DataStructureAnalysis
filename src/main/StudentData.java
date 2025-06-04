package main;

public class StudentData {

    private String studentId;
    private int age;
    private String gender;
    private float studyHoursPerDay;
    private float socialMediaHours;
    private float netflixHours;
    private boolean partTimeJob;
    private float attendancePercentage;
    private float sleepHours;
    private String dietQuality;
    private int exerciseFrequency;
    private String parentalEducationLevel;
    private String internetQuality;
    private int mentalHealthRating;
    private boolean extracurricularParticipation;
    private float examScore;

    public StudentData(){
        this(
            null,
            0,
            null,
            0,
            0,
            0,
            false,
            0,
            0,
            null,
            0,
            null,
            null,
            0,
            false,
            0
        );
    }

    public StudentData(
            String studentId,
            int age,
            String gender,
            float studyHoursPerDay,
            float socialMediaHours,
            float netflixHours,
            boolean partTimeJob,
            float attendancePercentage,
            float sleepHours,
            String dietQuality,
            int exerciseFrequency,
            String parentalEducationLevel,
            String internetQuality,
            int mentalHealthRating,
            boolean extracurricularParticipation,
            float examScore
    ){
        this.studentId = studentId;
        this.age = age;
        this.gender = gender;
        this.studyHoursPerDay = studyHoursPerDay;
        this.socialMediaHours = socialMediaHours;
        this.netflixHours = netflixHours;
        this.partTimeJob = partTimeJob;
        this.attendancePercentage = attendancePercentage;
        this.sleepHours = sleepHours;
        this.dietQuality = dietQuality;
        this.exerciseFrequency = exerciseFrequency;
        this.parentalEducationLevel = parentalEducationLevel;
        this.internetQuality = internetQuality;
        this.mentalHealthRating = mentalHealthRating;
        this.extracurricularParticipation = extracurricularParticipation;
        this.examScore = examScore;
    }


    public boolean isExtracurricularParticipation() {
        return extracurricularParticipation;
    }

    public void setExtracurricularParticipation(boolean extracurricularParticipation) {
        this.extracurricularParticipation = extracurricularParticipation;
    }

    public float getExamScore() {
        return examScore;
    }

    public void setExamScore(float examScore) {
        this.examScore = examScore;
    }

    public int getMentalHealthRating() {
        return mentalHealthRating;
    }

    public void setMentalHealthRating(int mentalHealthRating) {
        this.mentalHealthRating = mentalHealthRating;
    }

    public String getInternetQuality() {
        return internetQuality;
    }

    public void setInternetQuality(String internetQuality) {
        this.internetQuality = internetQuality;
    }

    public String getParentalEducationLevel() {
        return parentalEducationLevel;
    }

    public void setParentalEducationLevel(String parentalEducationLevel) {
        this.parentalEducationLevel = parentalEducationLevel;
    }

    public int getExerciseFrequency() {
        return exerciseFrequency;
    }

    public void setExerciseFrequency(int exerciseFrequency) {
        this.exerciseFrequency = exerciseFrequency;
    }

    public String getDietQuality() {
        return dietQuality;
    }

    public void setDietQuality(String dietQuality) {
        this.dietQuality = dietQuality;
    }

    public float getSleepHours() {
        return sleepHours;
    }

    public void setSleepHours(float sleepHours) {
        this.sleepHours = sleepHours;
    }

    public float getAttendancePercentage() {
        return attendancePercentage;
    }

    public void setAttendancePercentage(float attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }

    public boolean isPartTimeJob() {
        return partTimeJob;
    }

    public void setPartTimeJob(boolean partTimeJob) {
        this.partTimeJob = partTimeJob;
    }

    public float getNetflixHours() {
        return netflixHours;
    }

    public void setNetflixHours(float netflixHours) {
        this.netflixHours = netflixHours;
    }

    public float getSocialMediaHours() {
        return socialMediaHours;
    }

    public void setSocialMediaHours(float socialMediaHours) {
        this.socialMediaHours = socialMediaHours;
    }

    public float getStudyHoursPerDay() {
        return studyHoursPerDay;
    }

    public void setStudyHoursPerDay(float studyHoursPerDay) {
        this.studyHoursPerDay = studyHoursPerDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
