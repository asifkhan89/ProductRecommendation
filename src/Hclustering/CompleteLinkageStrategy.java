
package Hclustering;

import java.util.Collection;

public class CompleteLinkageStrategy implements LinkageStrategy {

	public Distance calculateDistance(Collection<Distance> distances) {
		double max = Double.NaN;

		for (Distance dist : distances) {
                    //check no same or chek with prev max
		    if (Double.isNaN(max) || dist.getDistance() > max)
		        max = dist.getDistance();
		}
		return new Distance(max);
	}
}
