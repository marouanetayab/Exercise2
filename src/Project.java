
public class Project {
	public static String[][] s;
	
	public Project(String[][] strings)
	{
		s = strings;
	}
	public static boolean isWellSorted(String[] strings){
		boolean isSorted = false;
		for(int i=0; i<strings.length-1; i++ )
		{
			isSorted = false;
			for(int j=i+1; j<strings.length; j++)
			{
				
				for(int k=0; k< s.length; k++)
				{
					
					if((strings[i].equals(s[k][0]) && strings[j].equals(s[k][1])))
						{
							isSorted = true;
						}
				}
				
			}
			if(isSorted == false)
				break;
		}
		if(isSorted)
			return true;
		else
			return false;
	}
}
