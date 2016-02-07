package extensions.pmd;

import java.sql.SQLException;
import java.util.List;

import net.sourceforge.pmd.lang.rule.AbstractRule;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.RuleContext;

public class DontThrowSQLExceptionRule extends AbstractRule {

	@Override @SuppressWarnings("PMD.SystemPrintln")
	public void apply(List<? extends Node> nodes, RuleContext ctx) {
		for (Node node : nodes) {
			if (node.toString().equals("NameList")) {
				for (int j = 0; j < node.jjtGetNumChildren(); j++) {
					final Node nameListElement = node.jjtGetChild(j);
					System.out.printf("Namelist element %s%n", nameListElement);
					if (nameListElement.hasDescendantOfType(SQLException.class)) {
						addViolation(ctx, node);	// note: reversed order from visit()
						return;						// only need one occurrence
					}
				}
			}
		}
	}
}
