package extensions.pmd;

import net.sourceforge.pmd.AbstractRule;
import net.sourceforge.pmd.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.ast.Node;

public class DontThrowSQLExceptionRule extends AbstractRule {
	DontThrowSQLExceptionRule() {
		super();
	}
	@Override
	public Object visit(final ASTMethodDeclaration node, final Object data) {
		System.out.printf("DontThrowSQLExceptionRule.visit(%s, %s)%n", node, data);
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			final Node child = node.jjtGetChild(i);
			System.out.printf("node %d child %s%n", i, child);
		}
		// if (nameList contains SQLException) {
		//	addViolation(data, node);
		// }
		return super.visit(node, data);
	}
}
