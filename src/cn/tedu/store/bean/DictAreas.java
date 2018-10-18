package cn.tedu.store.bean;

public class DictAreas {
    private Integer id;

    private String cityCode;

    private String areaCode;

    private String areaName;

    public DictAreas(Integer id, String cityCode, String areaCode, String areaName) {
        this.id = id;
        this.cityCode = cityCode;
        this.areaCode = areaCode;
        this.areaName = areaName;
    }

    public DictAreas() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }
}