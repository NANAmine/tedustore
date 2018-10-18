package cn.tedu.store.bean;

public class DictCities {
    private Integer id;

    private String provinceCode;

    private String cityCode;

    private String cityName;

    public DictCities(Integer id, String provinceCode, String cityCode, String cityName) {
        this.id = id;
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public DictCities() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }
}