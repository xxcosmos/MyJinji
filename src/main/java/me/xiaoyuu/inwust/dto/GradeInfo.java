package me.xiaoyuu.inwust.dto;

/**
 *   {
 *     "xh": "201713137042",
 *     "xm": "张啸宇",
 *     "kkxq": "2017-2018-2",
 *     "kcxzmc": "学科基础平台课程",
 *     "ksxzmc": "正常考试",
 *     "xq": null,
 *     "jd": 2,
 *     "cjbsmc": null,
 *     "zcj": "70",
 *     "kclbmc": "必修",
 *     "zxs": 40,
 *     "kcmc": "大学物理B(一)"
 *   }
 */
public class GradeInfo {
    private String xh;
    private String xm;
    private String kkxq;
    private String kcxzmc;
    private String ksxzmc;
    private String xq;
    private int jd;
    private String cjbsmc;
    private String zcj;
    private String kclbmc;
    private int zxs;
    private String kcmc;
    private double xf;

    @Override
    public String toString() {
        return "GradeInfo{" +
                "xh='" + xh + '\'' +
                ", xm='" + xm + '\'' +
                ", kkxq='" + kkxq + '\'' +
                ", kcxzmc='" + kcxzmc + '\'' +
                ", ksxzmc='" + ksxzmc + '\'' +
                ", xq='" + xq + '\'' +
                ", jd=" + jd +
                ", cjbsmc='" + cjbsmc + '\'' +
                ", zcj='" + zcj + '\'' +
                ", kclbmc='" + kclbmc + '\'' +
                ", zxs=" + zxs +
                ", kcmc='" + kcmc + '\'' +
                ", xf=" + xf +
                '}';
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getKkxq() {
        return kkxq;
    }

    public void setKkxq(String kkxq) {
        this.kkxq = kkxq;
    }

    public String getKcxzmc() {
        return kcxzmc;
    }

    public void setKcxzmc(String kcxzmc) {
        this.kcxzmc = kcxzmc;
    }

    public String getKsxzmc() {
        return ksxzmc;
    }

    public void setKsxzmc(String ksxzmc) {
        this.ksxzmc = ksxzmc;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public int getJd() {
        return jd;
    }

    public void setJd(int jd) {
        this.jd = jd;
    }

    public String getCjbsmc() {
        return cjbsmc;
    }

    public void setCjbsmc(String cjbsmc) {
        this.cjbsmc = cjbsmc;
    }

    public String getZcj() {
        return zcj;
    }

    public void setZcj(String zcj) {
        this.zcj = zcj;
    }

    public String getKclbmc() {
        return kclbmc;
    }

    public void setKclbmc(String kclbmc) {
        this.kclbmc = kclbmc;
    }

    public int getZxs() {
        return zxs;
    }

    public void setZxs(int zxs) {
        this.zxs = zxs;
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    public double getXf() {
        return xf;
    }

    public void setXf(double xf) {
        this.xf = xf;
    }
}
