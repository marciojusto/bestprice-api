package com.bestprice.api.error;

public class ResourceNotFoundDetail extends ErrorDetail {

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String titulo;
		private int status;
		private String detalhe;
		private long timestamp;
		private String developerMessage;

		private Builder() {
		}

		public Builder Titulo(String titulo) {
			this.titulo = titulo;
			return this;
		}

		public Builder Status(int status) {
			this.status = status;
			return this;
		}

		public Builder Detalhe(String detalhe) {
			this.detalhe = detalhe;
			return this;
		}

		public Builder Timestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder DeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ResourceNotFoundDetail build() {

			ResourceNotFoundDetail detail = new ResourceNotFoundDetail();

			detail.setTitulo(titulo);
			detail.setDetalhe(detalhe);
			detail.setStatus(status);
			detail.setTimestamp(timestamp);
			detail.setDeveloperMessage(developerMessage);

			return detail;
		}
	}

}
