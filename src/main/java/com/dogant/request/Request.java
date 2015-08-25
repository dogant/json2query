package com.dogant.request;

import com.dogant.criteria.Criteria;
import com.dogant.selection.Selection;

public class Request {

   /*
    * Main JSON request, basically split into two parts Criteria and Selection
    * Criteria is list of items for filtering data Selections are the axes on
    * the 2d or 3d charts
    */

   public Criteria criteria;
   public Selection selection;

   public Criteria getCriteria() {
      return criteria;
   }

   public void setCriteria(Criteria criteria) {
      this.criteria = criteria;
   }

   public Boolean hasCriteria() {
      return criteria != null;
   }

   public Selection getSelection() {
      return selection;
   }

   public void setSelection(Selection selection) {
      this.selection = selection;
   }

   public Boolean hasSelection() {
      return selection != null;
   }

}
