
package Hclustering;

import java.util.Collection;

public interface LinkageStrategy {

	public Distance calculateDistance(Collection<Distance> distances);
}
