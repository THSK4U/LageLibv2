package Metier;

public class commenter {
		
		private int id_comment;
		private int id_livre;
		private String commenter;
		
		
		public commenter() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public commenter(int id_livre, String commenter) {
			super();
			this.id_livre = id_livre;
			this.commenter = commenter;
		}


		public int getId_comment() {
			return id_comment;
		}
		public void setId_comment(int id_comment) {
			this.id_comment = id_comment;
		}
		public int getId_livre() {
			return id_livre;
		}
		public void setId_livre(int id_livre) {
			this.id_livre = id_livre;
		}
		public String getCommenter() {
			return commenter;
		}
		public void setCommenter(String commenter) {
			this.commenter = commenter;
		}
		public void setId_livre(long long1) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public String toString() {
			return "Avis [id_comment=" + id_comment + ", id_livre=" + id_livre + ", commenter=" + commenter + "]";
		}
	 
}
