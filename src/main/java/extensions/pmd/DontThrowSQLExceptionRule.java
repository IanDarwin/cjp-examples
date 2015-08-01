package extensions.pmd;

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
				}
			}
		}
		// if (nameList contains SQLException) {
		//	addViolation(data, node);	// note: reversed order from visit()
		// }
	}
}
