package entity;

import java.sql.Time;

    public class Fly {
        private String flyCode;
        private String GaDi;
        private String GaDen;
        private int DoDai;
        private int ChiPhi;
        private Time GioDi;
        private Time GioDen;

        public Fly() {
        }

        public Fly(String flyCode, String gaDi, String gaDen, int doDai, int chiPhi, Time gioDi, Time gioDen) {
            this.flyCode = flyCode;
            this.GaDi = gaDi;
            this.GaDen = gaDen;
            this.DoDai = doDai;
            this.ChiPhi = chiPhi;
            this.GioDi = gioDi;
            this.GioDen = gioDen;
        }

        public String getFlyCode() {
            return this.flyCode;
        }

        public void setFlyCode(String flyCode) {
            this.flyCode = flyCode;
        }

        public String getGaDi() {
            return this.GaDi;
        }

        public void setGaDi(String gaDi) {
            this.GaDi = gaDi;
        }

        public String getGaDen() {
            return this.GaDen;
        }

        public void setGaDen(String gaDen) {
            this.GaDen = gaDen;
        }

        public int getDoDai() {
            return this.DoDai;
        }

        public void setDoDai(int doDai) {
            this.DoDai = doDai;
        }

        public int getChiPhi() {
            return this.ChiPhi;
        }

        public void setChiPhi(int chiPhi) {
            this.ChiPhi = chiPhi;
        }

        public Time getGioDi() {
            return this.GioDi;
        }

        public void setGioDi(Time gioDi) {
            this.GioDi = gioDi;
        }

        public Time getGioDen() {
            return this.GioDen;
        }

        public void setGioDen(Time gioDen) {
            this.GioDen = gioDen;
        }
    }
