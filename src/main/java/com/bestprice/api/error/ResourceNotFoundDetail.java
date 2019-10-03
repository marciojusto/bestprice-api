	package com.bestprice.api.error;

public class ResourceNotFoundDetail {

	private String titulo;
	private int status;
	private String detalhe;
	private long timestamp;
	private String developerMessage;

	private ResourceNotFoundDetail(Builder builder) {
		this.titulo = builder.titulo;
		this.status = builder.status;
		this.detalhe = builder.detalhe;
		this.timestamp = builder.timestamp;
		this.developerMessage = builder.developerMessage;
	}
	
	private ResourceNotFoundDetail() {}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

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
			return new ResourceNotFoundDetail(this);
		}
	}
	
	
}
