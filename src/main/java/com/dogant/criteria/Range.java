package com.dogant.criteria;

public class Range {

   private Integer min, max;

   public Range() {

   }

   public Range(Integer min, Integer max) {
      this.min = min;
      this.max = max;
   }

   public int getMin() {
      return min;
   }

   public void setMin(int min) {
      this.min = min;
   }

   public int getMax() {
      return max;
   }

   public void setMax(int max) {
      this.max = max;
   }

   public Boolean hasMin() {

      return min != null;
   }

   public Boolean hasMax() {
      return max != null;
   }

}
