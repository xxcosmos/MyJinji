package me.xiaoyuu.inwust.dto;

public class JacseerCourseInfo {
    private String jsxm;
    private String kcmc;
    private String avg_grade;
    private String max_grade;
    private String min_grade;
    private String pass_percent;
    private String std;
    private String counts;

    @Override
    public String toString() {
        return "JacseerCourseInfo{" +
                "jsxm='" + jsxm + '\'' +
                ", kcmc='" + kcmc + '\'' +
                ", avg_grade='" + avg_grade + '\'' +
                ", max_grade='" + max_grade + '\'' +
                ", min_grade='" + min_grade + '\'' +
                ", pass_percent='" + pass_percent + '\'' +
                ", std='" + std + '\'' +
                ", counts='" + counts + '\'' +
                '}';
    }

    public String getJsxm() {
        return jsxm;
    }

    public void setJsxm(String jsxm) {
        this.jsxm = jsxm;
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    public String getAvg_grade() {
        return avg_grade;
    }

    public void setAvg_grade(String avg_grade) {
        this.avg_grade = avg_grade;
    }

    public String getMax_grade() {
        return max_grade;
    }

    public void setMax_grade(String max_grade) {
        this.max_grade = max_grade;
    }

    public String getMin_grade() {
        return min_grade;
    }

    public void setMin_grade(String min_grade) {
        this.min_grade = min_grade;
    }

    public String getPass_percent() {
        return pass_percent;
    }

    public void setPass_percent(String pass_percent) {
        this.pass_percent = pass_percent;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }
}
