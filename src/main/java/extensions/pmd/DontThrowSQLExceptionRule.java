package extensions.pmd;

import net.sourceforge.pmd.AbstractRule;
import net.sourceforge.pmd.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.ast.Node;

public class DontThrowSQLExceptionRule extends AbstractRule {

	@Override @SuppressWarnings("PMD.SystemPrintln")
	public Object visit(final ASTMethodDeclaration node, final Object data) {
		// System.out.printf("DontThrowSQLExceptionRule.visit(%s, %s)%n", node, data);
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			final Node child = node.jjtGetChild(i);

			// System.out.printf("node %d child %s%n", i, child);
			if (child.toString().equals("NameList")) {
				for (int j = 0; j < child.jjtGetNumChildren(); j++) {
					final Node nameListElement = child.jjtGetChild(j);
					System.out.printf("Namelist element %s%n", nameListElement);
				}
			}
		}
		// if (nameList contains SQLException) {
		//	addViolation(data, node);	// note: reversed order from visit()
		// }
		return super.visit(node, data);
	}
}
