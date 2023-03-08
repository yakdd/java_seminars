public class Notebook {
    public String brand;
    public String cpu;
    public Integer ram;
    public Integer ssd;
    public String os;
    public Integer price;

    public Notebook(String brand, String cpu, Integer ram, Integer ssd, String os, Integer price) {
        this.brand = brand;
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.os = os;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n Бренд:                 " + brand +
                "\n процессор:             " + cpu +
                "\n оперативная память:    " + ram + " Гб" +
                "\n объем SSD:             " + ssd + " Гб" +
                "\n операционная система:  " + os +
                "\n цена:                  " + price + " руб" +
                "\n---------------------------------------------";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((cpu == null) ? 0 : cpu.hashCode());
        result = prime * result + ((ram == null) ? 0 : ram.hashCode());
        result = prime * result + ((ssd == null) ? 0 : ssd.hashCode());
        result = prime * result + ((os == null) ? 0 : os.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof Notebook))
            return false;

        Notebook other = (Notebook) obj;
        return this.brand.equals(other.brand) &&
                this.cpu.equals(other.cpu) &&
                this.ram.equals(other.ram) &&
                this.ssd.equals(other.ssd) &&
                this.price.equals(other.price);
    }

    public String getBrand() {
        return brand;
    }

    public String getCpu() {
        return cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getSsd() {
        return ssd;
    }

    public String getOs() {
        return os;
    }

    public Integer getPrice() {
        return price;
    }

}
