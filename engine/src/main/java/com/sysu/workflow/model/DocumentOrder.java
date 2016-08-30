
package com.sysu.workflow.model;

import java.util.Comparator;

/**
 * DocumentOrder is implemented by {@link EnterableState} and {@link Transition} elements in the SCXML document
 * representing their document order,
 * <p>
 * They are ordered with ancestor states before their descendant states,
 * and the transitions within a state in document order before any descendant states.
 * </p>
 * <p>Note: it is assumed there will be no more than Integer.MAX_VALUE of such elements in a single SCXML document</p>
 */
public interface DocumentOrder {

    Comparator<com.sysu.workflow.model.DocumentOrder> documentOrderComparator = new Comparator<com.sysu.workflow.model.DocumentOrder>() {

        public int compare(final com.sysu.workflow.model.DocumentOrder o1, final com.sysu.workflow.model.DocumentOrder o2) {
            return o1.getOrder() - o2.getOrder();
        }
    };

    Comparator<com.sysu.workflow.model.DocumentOrder> reverseDocumentOrderComparator = new Comparator<com.sysu.workflow.model.DocumentOrder>() {

        public int compare(final com.sysu.workflow.model.DocumentOrder o1, final com.sysu.workflow.model.DocumentOrder o2) {
            return o2.getOrder() - o1.getOrder();
        }
    };

    /**
     * @return the relative document order within the SCXML document of this element
     */
    int getOrder();
}
