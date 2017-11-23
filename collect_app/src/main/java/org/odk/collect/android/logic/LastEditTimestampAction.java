package org.odk.collect.android.logic;

import com.fasterxml.jackson.core.TreeNode;

import org.javarosa.core.model.Action;
import org.javarosa.core.model.FormDef;
import org.javarosa.core.model.data.DateTimeData;
import org.javarosa.core.model.instance.AbstractTreeElement;
import org.javarosa.core.model.instance.TreeElement;
import org.javarosa.core.model.instance.TreeReference;

import java.util.Date;


public class LastEditTimestampAction extends Action {

    @Override
    public void processAction(FormDef model, TreeReference context) {
        super.processAction(model, context);

        final String updatedNodeName = context.getNameLast();
        final AbstractTreeElement<TreeElement> parent = model.getMainInstance().resolveReference(context).getParent();

        final String timstampNodeName = updatedNodeName + "__Timestamp";
        if (parent.getChildrenWithName(timstampNodeName) != null && parent.getChildrenWithName(timstampNodeName).size() > 0) {
            final TreeElement timestamp = parent.getChildrenWithName(timstampNodeName).get(0);
            timestamp.setValue(new DateTimeData(new Date()));
        }
    }
}
