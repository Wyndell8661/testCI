package com.example.demo;

/**
 * @Author: JinWenPeng
 * @Date: 2019/11/28 21:49
 */
public class BuilderObject {

    private Long id;
    private String name;

    //optional varibales;
    private Boolean enabled;
    private String status;

    @Override
    public String toString() {
        return "BuilderObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Builder newBuilder(String name,Long id){
        return new Builder(id,name);
    }

    static class Builder{
        private Long id;
        private String name;
        //optional varibales;
        private Boolean enabled;
        private String status;

        private Builder(Long id,String name){
            this.id = id;
            this.name = name;
        }

        public Builder isEnable(Boolean flag){
            this.enabled = flag;
            return this;
        }

        public Builder ofStatus(String status){
            this.status = status;
            return this;
        }

        public BuilderObject build(){
            BuilderObject result = new BuilderObject();
            result.setId(this.id);
            result.setEnabled(this.enabled);
            result.setName(this.name);
            result.setStatus(this.status);
            return result;
        }
    }
}


class Test{
    public static void main(String[] args) {
        BuilderObject jinwepeng = BuilderObject.newBuilder("jinwepeng", 100L).build();
        BuilderObject wanglei = BuilderObject.newBuilder("wanglei", 200L).ofStatus("normal").isEnable(false).build();
        System.out.println(jinwepeng);
        System.out.println(wanglei);
    }
}
