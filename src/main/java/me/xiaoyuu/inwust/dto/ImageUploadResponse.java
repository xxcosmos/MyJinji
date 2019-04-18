package me.xiaoyuu.inwust.dto;

public class ImageUploadResponse {
    private String code;
    private ImageUploadSuccessData data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ImageUploadSuccessData getData() {
        return data;
    }

    public void setData(ImageUploadSuccessData data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ImageUploadResponse{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
